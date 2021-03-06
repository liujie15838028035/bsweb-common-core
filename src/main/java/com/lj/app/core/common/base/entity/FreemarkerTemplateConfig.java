package com.lj.app.core.common.base.entity;

/**
 * reemarker模版配置
 */
public class FreemarkerTemplateConfig extends BaseEntity {

  /**
   * id
   */
  private java.lang.Integer id;

  /**
   * 模版编号 TEMPLATE_NO
   */
  private String templateNo;

  /**
   * 模版名称 TEMPLATE_NAME
   */
  private String templateName;

  /**
   * 模版路径 TEMPLATE_PATH
   */
  private String templatePath;

  /**
   * 模版内容 TEMPLATE_CONENT
   */
  private String templateConent;

  /**
   * 测试数据 TEST_DATA
   */
  private String testData;

  /**
   * 测试邮箱 TEST_EMAIL
   */
  private String testEmail;

  /**
   * 备注 TEMPLATE_REMARK
   */
  private String templateRemark;

  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  public java.lang.Integer getId() {
    return this.id;
  }

  public void setTemplateNo(String value) {
    this.templateNo = value;
  }

  public String getTemplateNo() {
    return this.templateNo;
  }

  public void setTemplateName(String value) {
    this.templateName = value;
  }

  public String getTemplateName() {
    return this.templateName;
  }

  public void setTemplatePath(String value) {
    this.templatePath = value;
  }

  public String getTemplatePath() {
    return this.templatePath;
  }

  public void setTemplateConent(String value) {
    this.templateConent = value;
  }

  public String getTemplateConent() {
    return this.templateConent;
  }

  public void setTestData(String value) {
    this.testData = value;
  }

  public String getTestData() {
    return this.testData;
  }

  public void setTestEmail(String value) {
    this.testEmail = value;
  }

  public String getTestEmail() {
    return this.testEmail;
  }

  public void setTemplateRemark(String value) {
    this.templateRemark = value;
  }

  public String getTemplateRemark() {
    return this.templateRemark;
  }
}
