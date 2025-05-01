<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="2.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:tns="http://food_delivery_app.nswi145.betse.mff/"
    xmlns:foaf="http://xmlns.com/foaf/0.1/"
    xmlns:schema="http://schema.org/"
    xmlns:ex="http://example.org/"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema#"
    exclude-result-prefixes="soap tns">

  <xsl:output method="text" encoding="UTF-8"/>

  <xsl:template match="/">
    <xsl:text>
@prefix rdf:    &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix xsd:    &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix foaf:   &lt;http://xmlns.com/foaf/0.1/&gt; .
@prefix schema: &lt;http://schema.org/&gt; .
@prefix ex:     &lt;http://example.org/&gt; .

</xsl:text>
    <xsl:apply-templates select="//tns:sendOrderRequest/orderRequest"/>
  </xsl:template>

  <xsl:template match="orderRequest">
    <xsl:variable name="oid" select="orderId"/>
    <xsl:variable name="cust" select="customerName"/>
    <xsl:variable name="custEscaped" select="replace($cust, ' ', '%20')"/>

    <!-- Order block -->
    <xsl:text>&lt;https://example.org/restaurant/orders/</xsl:text>
    <xsl:value-of select="$oid"/>
    <xsl:text>&gt; a schema:Order ;
    schema:orderNumber "</xsl:text>
    <xsl:value-of select="$oid"/>
    <xsl:text>" ;
    schema:customer &lt;https://example.org/restaurant/customers/</xsl:text>
    <xsl:value-of select="$custEscaped"/>
    <xsl:text>&gt;
</xsl:text>
    <xsl:for-each select="foodItems/foodItem">
      <xsl:text>    schema:orderedItem &lt;https://example.org/restaurant/menuItems/</xsl:text>
      <xsl:value-of select="$oid"/>
      <xsl:text>/</xsl:text>
      <xsl:value-of select="position()"/>
      <xsl:text>&gt;</xsl:text>
      <xsl:choose>
        <xsl:when test="position() != last()">
          <xsl:text> ;</xsl:text>
        </xsl:when>
        <xsl:otherwise>
          <xsl:text> .</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:text>
</xsl:text>
    </xsl:for-each>

    <!-- Customer block -->
    <xsl:text>&lt;https://example.org/restaurant/customers/</xsl:text>
    <xsl:value-of select="$custEscaped"/>
    <xsl:text>&gt; a foaf:Person ;
    foaf:name "</xsl:text>
    <xsl:value-of select="$cust"/>
    <xsl:text>" .
    
</xsl:text>

    <!-- MenuItem blocks -->
    <xsl:for-each select="foodItems/foodItem">
      <xsl:text>&lt;https://example.org/restaurant/menuItems/</xsl:text>
      <xsl:value-of select="$oid"/>
      <xsl:text>/</xsl:text>
      <xsl:value-of select="position()"/>
      <xsl:text>&gt; a schema:MenuItem ;
    schema:name "</xsl:text>
      <xsl:value-of select="name"/>
      <xsl:text>" ;
    schema:orderQuantity "</xsl:text>
      <xsl:value-of select="quantity"/>
      <xsl:text>"^^xsd:integer .

</xsl:text>
    </xsl:for-each>

    <!-- Service block -->
    <xsl:text>&lt;https://example.org/restaurant/services/main&gt; a ex:RestaurantOrderService ;
    ex:processes &lt;https://example.org/restaurant/orders/</xsl:text>
    <xsl:value-of select="$oid"/>
    <xsl:text>&gt; .</xsl:text>
  </xsl:template>

</xsl:stylesheet>
