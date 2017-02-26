// Generated from MySQLParser.g4 by ANTLR 4.4
package antlr.autogen;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MySQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MySQLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MySQLParser#where_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_clause(@NotNull MySQLParser.Where_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery(@NotNull MySQLParser.SubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#partition_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_clause(@NotNull MySQLParser.Partition_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#simple_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expression(@NotNull MySQLParser.Simple_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(@NotNull MySQLParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#select_key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_key(@NotNull MySQLParser.Select_keyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#expr_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_op(@NotNull MySQLParser.Expr_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#index_hint_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_hint_list(@NotNull MySQLParser.Index_hint_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name_alias(@NotNull MySQLParser.Column_name_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#relational_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_op(@NotNull MySQLParser.Relational_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#index_hint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_hint(@NotNull MySQLParser.Index_hintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#column_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_list(@NotNull MySQLParser.Column_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#index_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_name(@NotNull MySQLParser.Index_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#right_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_element(@NotNull MySQLParser.Right_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#partition_names}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_names(@NotNull MySQLParser.Partition_namesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#partition_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartition_name(@NotNull MySQLParser.Partition_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(@NotNull MySQLParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquery_alias(@NotNull MySQLParser.Subquery_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#left_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_element(@NotNull MySQLParser.Left_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_factor1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_factor1(@NotNull MySQLParser.Table_factor1Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull MySQLParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_factor3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_factor3(@NotNull MySQLParser.Table_factor3Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull MySQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_factor2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_factor2(@NotNull MySQLParser.Table_factor2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_factor4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_factor4(@NotNull MySQLParser.Table_factor4Context ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name(@NotNull MySQLParser.Column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_atom(@NotNull MySQLParser.Table_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#schema_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_name(@NotNull MySQLParser.Schema_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#column_list_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_list_clause(@NotNull MySQLParser.Column_list_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_or_is_not(@NotNull MySQLParser.Is_or_is_notContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#index_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_list(@NotNull MySQLParser.Index_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_references}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_references(@NotNull MySQLParser.Table_referencesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#select_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_clause(@NotNull MySQLParser.Select_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#join_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_condition(@NotNull MySQLParser.Join_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#join_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_clause(@NotNull MySQLParser.Join_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#from_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrom_clause(@NotNull MySQLParser.From_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_reference(@NotNull MySQLParser.Table_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#target_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget_element(@NotNull MySQLParser.Target_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#index_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_options(@NotNull MySQLParser.Index_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_alias(@NotNull MySQLParser.Table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MySQLParser#between_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween_op(@NotNull MySQLParser.Between_opContext ctx);
}