var tree = new MzTreeView("tree");

tree.icons["property"] = "property.gif";
tree.icons["css"] = "collection.gif";
tree.icons["event"] = "collection.gif";
tree.icons["book"]  = "book.gif";
tree.iconsExpand["book"] = "bookopen.gif";
tree.setIconPath("mzTree/"); //չ��ʱ��Ӧ��ͼƬ�Ĵ��·��

tree.nodes["0_1"] = "text:�й�;url:#";

tree.nodes["1_2"] = "text:����;url:/Contract/index";

tree.nodes["2_3"] = "text:�Ƹ�;url:/Contract/index";

document.write(tree.toString());