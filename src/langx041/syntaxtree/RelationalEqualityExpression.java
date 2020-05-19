/* Generated by JTB 1.4.11 */
package langx041.syntaxtree;

import langx041.visitor.*;

public class RelationalEqualityExpression implements INode {

  public RelationalGreaterExpression f0;

  public NodeListOptional f1;

  private static final long serialVersionUID = 1411L;

  public RelationalEqualityExpression(final RelationalGreaterExpression n0, final NodeListOptional n1) {
    f0 = n0;
    f1 = n1;
  }

  @Override
  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  @Override
  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  @Override
  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}
