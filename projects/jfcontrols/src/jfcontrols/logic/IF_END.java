package jfcontrols.logic;

/** If End
 *
 * }
 *
 * Ends a block of code.
 *
 * See IF for starting block of code.
 *
 * @author pquiring
 */

import javaforce.controls.*;
import jfcontrols.tags.TagBase;

public class IF_END extends LogicBlock {

  public boolean isBlock() {
    return false;
  }

  public String getDesc() {
    return "}";
  }

  public boolean doIfEnd;

  public boolean execute(boolean enabled) {
    doIfEnd = enabled;
    return enabled;
  }

  public int getTagsCount() {
    return 0;
  }

  public int getTagType(int idx) {
    return -1;
  }

  public boolean isSolo() {
    return true;
  }

  public boolean isFlowControl() {
    return true;
  }

  public boolean canClose(String name) {
    return name.equals("IF") || name.equals("WHILE");
  }

  public LogicBlock getNext() {
    return next;
  }
}
