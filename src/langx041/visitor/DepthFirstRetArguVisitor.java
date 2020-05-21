/* Generated by JTB 1.4.11 */
package langx041.visitor;

import langx041.syntaxtree.*;
import java.util.*;

public class DepthFirstRetArguVisitor<R, A> implements IRetArguVisitor<R, A> {


  @Override
  public R visit(final NodeChoice n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    final R nRes = n.choice.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final NodeList n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      @SuppressWarnings("unused")
      final R sRes = e.next().accept(this, argu);
    }
    return nRes;
  }

  @Override
  public R visit(final NodeListOptional n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    if (n.present()) {
      R nRes = null;
      for (final Iterator<INode> e = n.elements(); e.hasNext();) {
        @SuppressWarnings("unused")
        R sRes = e.next().accept(this, argu);
        }
      return nRes;
    } else
      return null;
  }

  @Override
  public R visit(final NodeOptional n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    if (n.present()) {
      final R nRes = n.node.accept(this, argu);
      return nRes;
    } else
      return null;
  }

  @Override
  public R visit(final NodeSequence n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      @SuppressWarnings("unused")
      R subRet = e.next().accept(this, argu);
    }
    return nRes;
  }

  @Override
  public R visit(final NodeTCF n, @SuppressWarnings("unused") final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return nRes;
  }

  @Override
  public R visit(final NodeToken n, @SuppressWarnings("unused") final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return nRes;
  }

  @Override
  public R visit(final Start n, final A argu) {
    R nRes = null;
    // f0 -> ( #0 Require() #1 "." )+
    n.f0.accept(this, argu);
    // f1 -> ( StatementExpression() )*
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final Require n, final A argu) {
    R nRes = null;
    // f0 -> "require"
    n.f0.accept(this, argu);
    // f1 -> ( < IDENTIFIER > )+
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final MathExpression n, final A argu) {
    R nRes = null;
    // f0 -> AdditiveExpression()
    n.f0.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final AdditiveExpression n, final A argu) {
    R nRes = null;
    // f0 -> MultiplicativeExpression()
    n.f0.accept(this, argu);
    // f1 -> ( #0 ( %0 "+"
    // .. .. . .. | %1 "-" )
    // .. .. . #1 MultiplicativeExpression() )*
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final MultiplicativeExpression n, final A argu) {
    R nRes = null;
    // f0 -> UnaryExpression()
    n.f0.accept(this, argu);
    // f1 -> ( #0 ( %0 "*"
    // .. .. . .. | %1 "/"
    // .. .. . .. | %2 "%" )
    // .. .. . #1 UnaryExpression() )*
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final UnaryExpression n, final A argu) {
    R nRes = null;
    // f0 -> . %0 #0 "(" #1 MathExpression() #2 ")"
    // .. .. | %1 < INTEGER_LITERAL >
    // .. .. | %2 VariableName()
    n.f0.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final RelationalExpression n, final A argu) {
    R nRes = null;
    // f0 -> RelationalEqualityExpression()
    n.f0.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final RelationalEqualityExpression n, final A argu) {
    R nRes = null;
    // f0 -> RelationalGreaterExpression()
    n.f0.accept(this, argu);
    // f1 -> ( #0 ( %0 "=="
    // .. .. . .. | %1 "!=" )
    // .. .. . #1 RelationalGreaterExpression() )*
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final RelationalGreaterExpression n, final A argu) {
    R nRes = null;
    // f0 -> RelationalLessExpression()
    n.f0.accept(this, argu);
    // f1 -> ( #0 ( %0 ">"
    // .. .. . .. | %1 ">=" )
    // .. .. . #1 RelationalLessExpression() )*
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final RelationalLessExpression n, final A argu) {
    R nRes = null;
    // f0 -> UnaryRelational()
    n.f0.accept(this, argu);
    // f1 -> ( #0 ( %0 "<"
    // .. .. . .. | %1 "<=" )
    // .. .. . #1 UnaryRelational() )*
    n.f1.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final UnaryRelational n, final A argu) {
    R nRes = null;
    // f0 -> MathExpression()
    n.f0.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final IfExpression n, final A argu) {
    R nRes = null;
    // f0 -> "if"
    n.f0.accept(this, argu);
    // f1 -> RelationalExpression()
    n.f1.accept(this, argu);
    // f2 -> "do"
    n.f2.accept(this, argu);
    // f3 -> ( StatementExpression() )*
    n.f3.accept(this, argu);
    // f4 -> "stop"
    n.f4.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final WhileExpression n, final A argu) {
    R nRes = null;
    // f0 -> "loop_if"
    n.f0.accept(this, argu);
    // f1 -> RelationalExpression()
    n.f1.accept(this, argu);
    // f2 -> "do"
    n.f2.accept(this, argu);
    // f3 -> ( StatementExpression() )*
    n.f3.accept(this, argu);
    // f4 -> "stop"
    n.f4.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final VariableDeclaration n, final A argu) {
    R nRes = null;
    // f0 -> "let"
    n.f0.accept(this, argu);
    // f1 -> VariableName()
    n.f1.accept(this, argu);
    // f2 -> "="
    n.f2.accept(this, argu);
    // f3 -> MathExpression()
    n.f3.accept(this, argu);
    // f4 -> "."
    n.f4.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final VariableAssign n, final A argu) {
    R nRes = null;
    // f0 -> VariableName()
    n.f0.accept(this, argu);
    // f1 -> "="
    n.f1.accept(this, argu);
    // f2 -> MathExpression()
    n.f2.accept(this, argu);
    // f3 -> "."
    n.f3.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final VariableName n, final A argu) {
    R nRes = null;
    // f0 -> < IDENTIFIER >
    n.f0.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final JavaStaticMethods n, final A argu) {
    R nRes = null;
    // f0 -> < IDENTIFIER >
    n.f0.accept(this, argu);
    // f1 -> ( #0 "::" #1 < IDENTIFIER > )+
    n.f1.accept(this, argu);
    // f2 -> "("
    n.f2.accept(this, argu);
    // f3 -> MathExpression()
    n.f3.accept(this, argu);
    // f4 -> ( #0 "," #1 MathExpression() )*
    n.f4.accept(this, argu);
    // f5 -> ")"
    n.f5.accept(this, argu);
    // f6 -> "."
    n.f6.accept(this, argu);
    return nRes;
  }

  @Override
  public R visit(final StatementExpression n, final A argu) {
    R nRes = null;
    // f0 -> . %0 VariableDeclaration()
    // .. .. | %1 VariableAssign()
    // .. .. | %2 JavaStaticMethods()
    // .. .. | %3 IfExpression()
    // .. .. | %4 WhileExpression()
    n.f0.accept(this, argu);
    return nRes;
  }

}
