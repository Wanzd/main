alert(11)
var tree = new MzTreeView("tree");
					//定义一个树(注意，这里的参数tree和后面的tree.nodes必须相同，否则显示不出)

					tree.setIconPath("/images/"); //定义树的图片的目录

					tree.nodes['-1_1'] =
					"text:检验信息管理; ";
					tree.nodes['1_2'] = "text:外购产品检验组; ";
					tree.nodes['1_3'] = "text:最终产品检验; ";
					tree.nodes['1_4'] = "text:复检情况;
					";
					tree.nodes['1_5'] = "text:办公辅助; ";
					tree.nodes['1_6'] =
					"text:基础信息管理; ";
					tree.nodes['1_7'] = "text:部门意见与建议; ";
					tree.nodes['1_8'] = "text:系统意见与建议; ";
					tree.nodes['2_11'] =
					"text:子文件夹测试一; ";
					tree.nodes['2_12'] = "text:子文件夹测试二; ";

					<!--
						示例如上，给树添加内容，-1为根节点，_后面的是子节点，依次显示
					-->

					document.write(tree.toString());