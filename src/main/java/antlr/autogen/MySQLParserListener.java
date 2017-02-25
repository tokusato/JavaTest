// Generated from MySQLParser.g4 by ANTLR 4.4
package antlr.autogen;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MySQLParser}.
 */
public interface MySQLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MySQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(@NotNull MySQLParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(@NotNull MySQLParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(@NotNull MySQLParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(@NotNull MySQLParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#partition_clause}.
	 * @param ctx the parse tree
	 */
	void enterPartition_clause(@NotNull MySQLParser.Partition_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#partition_clause}.
	 * @param ctx the parse tree
	 */
	void exitPartition_clause(@NotNull MySQLParser.Partition_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(@NotNull MySQLParser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(@NotNull MySQLParser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(@NotNull MySQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(@NotNull MySQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#select_key}.
	 * @param ctx the parse tree
	 */
	void enterSelect_key(@NotNull MySQLParser.Select_keyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#select_key}.
	 * @param ctx the parse tree
	 */
	void exitSelect_key(@NotNull MySQLParser.Select_keyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#expr_op}.
	 * @param ctx the parse tree
	 */
	void enterExpr_op(@NotNull MySQLParser.Expr_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#expr_op}.
	 * @param ctx the parse tree
	 */
	void exitExpr_op(@NotNull MySQLParser.Expr_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#index_hint_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_hint_list(@NotNull MySQLParser.Index_hint_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#index_hint_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_hint_list(@NotNull MySQLParser.Index_hint_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name_alias(@NotNull MySQLParser.Column_name_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#column_name_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name_alias(@NotNull MySQLParser.Column_name_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void enterRelational_op(@NotNull MySQLParser.Relational_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void exitRelational_op(@NotNull MySQLParser.Relational_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#index_hint}.
	 * @param ctx the parse tree
	 */
	void enterIndex_hint(@NotNull MySQLParser.Index_hintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#index_hint}.
	 * @param ctx the parse tree
	 */
	void exitIndex_hint(@NotNull MySQLParser.Index_hintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#column_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_list(@NotNull MySQLParser.Column_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#column_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_list(@NotNull MySQLParser.Column_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#index_name}.
	 * @param ctx the parse tree
	 */
	void enterIndex_name(@NotNull MySQLParser.Index_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#index_name}.
	 * @param ctx the parse tree
	 */
	void exitIndex_name(@NotNull MySQLParser.Index_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#right_element}.
	 * @param ctx the parse tree
	 */
	void enterRight_element(@NotNull MySQLParser.Right_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#right_element}.
	 * @param ctx the parse tree
	 */
	void exitRight_element(@NotNull MySQLParser.Right_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#partition_names}.
	 * @param ctx the parse tree
	 */
	void enterPartition_names(@NotNull MySQLParser.Partition_namesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#partition_names}.
	 * @param ctx the parse tree
	 */
	void exitPartition_names(@NotNull MySQLParser.Partition_namesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#partition_name}.
	 * @param ctx the parse tree
	 */
	void enterPartition_name(@NotNull MySQLParser.Partition_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#partition_name}.
	 * @param ctx the parse tree
	 */
	void exitPartition_name(@NotNull MySQLParser.Partition_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(@NotNull MySQLParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(@NotNull MySQLParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 */
	void enterSubquery_alias(@NotNull MySQLParser.Subquery_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#subquery_alias}.
	 * @param ctx the parse tree
	 */
	void exitSubquery_alias(@NotNull MySQLParser.Subquery_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#left_element}.
	 * @param ctx the parse tree
	 */
	void enterLeft_element(@NotNull MySQLParser.Left_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#left_element}.
	 * @param ctx the parse tree
	 */
	void exitLeft_element(@NotNull MySQLParser.Left_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_factor1}.
	 * @param ctx the parse tree
	 */
	void enterTable_factor1(@NotNull MySQLParser.Table_factor1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_factor1}.
	 * @param ctx the parse tree
	 */
	void exitTable_factor1(@NotNull MySQLParser.Table_factor1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull MySQLParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull MySQLParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_factor3}.
	 * @param ctx the parse tree
	 */
	void enterTable_factor3(@NotNull MySQLParser.Table_factor3Context ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_factor3}.
	 * @param ctx the parse tree
	 */
	void exitTable_factor3(@NotNull MySQLParser.Table_factor3Context ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull MySQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull MySQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_factor2}.
	 * @param ctx the parse tree
	 */
	void enterTable_factor2(@NotNull MySQLParser.Table_factor2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_factor2}.
	 * @param ctx the parse tree
	 */
	void exitTable_factor2(@NotNull MySQLParser.Table_factor2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_factor4}.
	 * @param ctx the parse tree
	 */
	void enterTable_factor4(@NotNull MySQLParser.Table_factor4Context ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_factor4}.
	 * @param ctx the parse tree
	 */
	void exitTable_factor4(@NotNull MySQLParser.Table_factor4Context ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(@NotNull MySQLParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(@NotNull MySQLParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_atom}.
	 * @param ctx the parse tree
	 */
	void enterTable_atom(@NotNull MySQLParser.Table_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_atom}.
	 * @param ctx the parse tree
	 */
	void exitTable_atom(@NotNull MySQLParser.Table_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#schema_name}.
	 * @param ctx the parse tree
	 */
	void enterSchema_name(@NotNull MySQLParser.Schema_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#schema_name}.
	 * @param ctx the parse tree
	 */
	void exitSchema_name(@NotNull MySQLParser.Schema_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#column_list_clause}.
	 * @param ctx the parse tree
	 */
	void enterColumn_list_clause(@NotNull MySQLParser.Column_list_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#column_list_clause}.
	 * @param ctx the parse tree
	 */
	void exitColumn_list_clause(@NotNull MySQLParser.Column_list_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 */
	void enterIs_or_is_not(@NotNull MySQLParser.Is_or_is_notContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#is_or_is_not}.
	 * @param ctx the parse tree
	 */
	void exitIs_or_is_not(@NotNull MySQLParser.Is_or_is_notContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#index_list}.
	 * @param ctx the parse tree
	 */
	void enterIndex_list(@NotNull MySQLParser.Index_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#index_list}.
	 * @param ctx the parse tree
	 */
	void exitIndex_list(@NotNull MySQLParser.Index_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_references}.
	 * @param ctx the parse tree
	 */
	void enterTable_references(@NotNull MySQLParser.Table_referencesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_references}.
	 * @param ctx the parse tree
	 */
	void exitTable_references(@NotNull MySQLParser.Table_referencesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void enterSelect_clause(@NotNull MySQLParser.Select_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void exitSelect_clause(@NotNull MySQLParser.Select_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#join_condition}.
	 * @param ctx the parse tree
	 */
	void enterJoin_condition(@NotNull MySQLParser.Join_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#join_condition}.
	 * @param ctx the parse tree
	 */
	void exitJoin_condition(@NotNull MySQLParser.Join_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#join_clause}.
	 * @param ctx the parse tree
	 */
	void enterJoin_clause(@NotNull MySQLParser.Join_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#join_clause}.
	 * @param ctx the parse tree
	 */
	void exitJoin_clause(@NotNull MySQLParser.Join_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void enterFrom_clause(@NotNull MySQLParser.From_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#from_clause}.
	 * @param ctx the parse tree
	 */
	void exitFrom_clause(@NotNull MySQLParser.From_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_reference}.
	 * @param ctx the parse tree
	 */
	void enterTable_reference(@NotNull MySQLParser.Table_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_reference}.
	 * @param ctx the parse tree
	 */
	void exitTable_reference(@NotNull MySQLParser.Table_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#target_element}.
	 * @param ctx the parse tree
	 */
	void enterTarget_element(@NotNull MySQLParser.Target_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#target_element}.
	 * @param ctx the parse tree
	 */
	void exitTarget_element(@NotNull MySQLParser.Target_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#index_options}.
	 * @param ctx the parse tree
	 */
	void enterIndex_options(@NotNull MySQLParser.Index_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#index_options}.
	 * @param ctx the parse tree
	 */
	void exitIndex_options(@NotNull MySQLParser.Index_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void enterTable_alias(@NotNull MySQLParser.Table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void exitTable_alias(@NotNull MySQLParser.Table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MySQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void enterBetween_op(@NotNull MySQLParser.Between_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MySQLParser#between_op}.
	 * @param ctx the parse tree
	 */
	void exitBetween_op(@NotNull MySQLParser.Between_opContext ctx);
}