package com.lj.app.core.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
/**
 * 
 * 脚本执行
 *
 */
public class ScriptRunnerUtil {
  private static final Logger LOG = LoggerFactory.getLogger(ScriptRunnerUtil.class);
  private static final String DEFAULT_DELIMITER = ";";
  // 数据库连接对象
  private Connection connection;
  // 是否自动提交
  private boolean autoCommit;
  // 默认的分隔符;
  private String delimiter = DEFAULT_DELIMITER;

  public ScriptRunnerUtil(Connection connection, boolean autoCommit) {
    this.connection = connection;
    this.autoCommit = autoCommit;
  }

  public void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  /**
   * 执行脚本
   * @param resource 资源名称
   * @throws IOException IO异常
   * @throws SQLException SQL异常
   */
  public void runScript(String resource) throws IOException, SQLException {
    Assert.notNull(resource);
    InputStream input = FileUtil.getStreamFromClasspath(resource);
    Reader reader = new InputStreamReader(input, "UTF-8");
    runScript(reader);
  }

  /**
   * 根据reader读取sql脚本，并运行
   * 
   * @param reader
   *          脚本资源
   */
  public void runScript(Reader reader) throws IOException, SQLException {
    Assert.notNull(connection);
    try {
      boolean originalAutoCommit = connection.getAutoCommit();
      try {
        if (originalAutoCommit != this.autoCommit) {
          connection.setAutoCommit(this.autoCommit);
        }
        runScript(connection, reader);
      } finally {
        connection.setAutoCommit(originalAutoCommit);
      }
    } catch (IOException e) {
      throw e;
    } catch (SQLException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error running script.  Cause: " + e, e);
    }
  }

  /**
   * 根据给定的sql脚本资源、数据库连接对象，执行sql脚本
   * 
   * @param conn
   *          数据库连接对象
   * @param reader
   *          sql脚本资源
   * @throws IOException
   *           io异常
   * @throws SQLException
   *           sql异常
   */
  private void runScript(Connection conn, Reader reader) throws IOException, SQLException {
    StringBuilder command = null;
    Statement statement  = null;
    try {
      LineNumberReader lineReader = new LineNumberReader(reader);
      String line = null;
      while ((line = lineReader.readLine()) != null) {
        if (command == null) {
          command = new StringBuilder();
        }
        String trimmedLine = line.trim();
        if (trimmedLine.startsWith("--")) {
          LOG.info(trimmedLine);
        } else if (trimmedLine.length() < 1 || trimmedLine.startsWith("//")) {
          // Do nothing
        } else if (trimmedLine.length() < 1 || trimmedLine.startsWith("--")) {
          // Do nothing
        } else if (trimmedLine.equals(getDelimiter()) || trimmedLine.endsWith(getDelimiter())) {
          command.append(line.substring(0, line.lastIndexOf(getDelimiter())));
          command.append(" ");
          statement = conn.createStatement();

          LOG.info(command.toString());
          try {
            statement.execute(command.toString());
          } catch (SQLException e) {
            e.fillInStackTrace();
            LOG.error("Error executing: " + command);
          }

          if (autoCommit && !conn.getAutoCommit()) {
            conn.commit();
          }
          command = null;
          try {
            statement.close();
          } catch (Exception e) {
            // ignore
          }
          Thread.yield();
        } else {
          command.append(line);
          command.append(" ");
        }
      }
      if (!autoCommit) {
        conn.commit();
      }
    } catch (SQLException e) {
      e.fillInStackTrace();
      throw e;
    } catch (IOException e) {
      e.fillInStackTrace();
      throw e;
    } finally{
      if(statement!=null)  {
        statement.close();
      }
      if(conn!=null)  {
          conn.close();
      }
    }
  }

  /**
   * 获取分隔符
   * 
   * @return delimiter
   */
  private String getDelimiter() {
    return delimiter;
  }
}
