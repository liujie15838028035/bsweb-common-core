package com.lj.app.core.common.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 树节点
 *
 */
public class TreeNode {
  private String id;

  private String text;

  private int checked;

  private List<TreeNode> children;

  public int getChecked() {
    return checked;
  }

  public void setChecked(int checked) {
    this.checked = checked;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  /**
   * 添加子节点
   * 
   * @param childrenNode
   *          添加子节点
   */
  public void addChildren(TreeNode childrenNode) {
    if (null == children) {
      children = new ArrayList<TreeNode>();
    }
    children.add(childrenNode);
  }

  public List<TreeNode> getChildren() {
    return children;
  }
}