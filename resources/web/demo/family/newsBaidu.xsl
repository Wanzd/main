<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method='html' version='1.0' encoding='GB2312'
		indent='yes' />
	<xsl:template match="/">
		<html>
			<body>
				<!-- script language="JavaScript" src="../js/mzTree/MzTreeView10.js" /-->
				<script language="JavaScript" src="newsBaidu.js" >alert(22);</script>
				
				<xsl:apply-templates select="person">
					<xsl:with-param name="level" select="'0'" />
				</xsl:apply-templates>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="person">

		<xsl:param name="level" />
		<p style="text-indent:{$level}em">
			<font size="3">
				<xsl:if test="@sex='male'">
					<xsl:attribute name="color">blue</xsl:attribute>

				</xsl:if>
				<xsl:if test="@sex!='male'">
					<xsl:attribute name="color">red</xsl:attribute>

				</xsl:if>
				<xsl:value-of select="@name" />
			</font>
			<td>
				<xsl:attribute name="title">age:
			<xsl:value-of select="@age" /></xsl:attribute>
			</td>
		</p>
		<xsl:apply-templates select="person">
			<xsl:with-param name="level" select="$level + 2" />
		</xsl:apply-templates>
	</xsl:template>
</xsl:stylesheet>