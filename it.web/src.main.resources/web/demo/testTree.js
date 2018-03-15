var tree = new MzTreeView("tree");

tree.icons["property"] = "property.gif";
tree.icons["css"] = "collection.gif";
tree.icons["event"] = "collection.gif";
tree.icons["book"]  = "book.gif";
tree.iconsExpand["book"] = "bookopen.gif";
tree.setIconPath("mzTree/"); //展开时对应的图片的存放路径

tree.nodes["0_1"] = "text:中国;url:#";

tree.nodes["1_2"] = "text:湖北;url:/Contract/index";

tree.nodes["2_3"] = "text:黄冈;url:/Contract/index";

document.write(tree.toString());