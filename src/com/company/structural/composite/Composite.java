package com.company.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Component</b> : defines an interface for all objects in the composition both the composite and the leaf nodes.
 * The Component may implement a default behavior for generic
 */

//Component Abstract :
abstract class HtmlTag {

    public abstract String getTagName();
    public abstract void setStartTag(String tag);
    public abstract void setEndTag(String tag);

    public void setTagBody (String tagBody){
        throw new UnsupportedOperationException("Current operation is not support for this object !");
    }

    public void addChildTag (HtmlTag htmlTag){
        throw new UnsupportedOperationException("Current operation is not support for this object !");
    }

    public void removeChildTag(HtmlTag htmlTag){
        throw new UnsupportedOperationException("Current operation is not support for this object !");
    }

    public List<HtmlTag> getChildTag(){
        throw new UnsupportedOperationException("Current operation is not support for this object !");
    }

    public abstract void generateHtmlTag();

}

/**
 * <b>Composite</b> : define the behavior of the components having children and to store child components.
 * The composite also implements the Leaf related operations. One composite also have many <b>Leaf method</b>
 */

class HtmlParentTag extends HtmlTag{

    private String tagName;
    private String startTag;
    private String endTag;
    private List<HtmlTag> childTag = new ArrayList<>();

    public HtmlParentTag (String tagName){
        this.tagName = tagName;
    }

    @Override
    public String getTagName() {
        return this.tagName;
    }

    @Override
    public void setStartTag(String tag) {
        this.startTag = tag;
    }

    @Override
    public void setEndTag(String tag) {
        this.endTag = tag;
    }

    @Override
    public void generateHtmlTag() {
        System.out.println(this.startTag);
        for(HtmlTag child : this.childTag){
            child.generateHtmlTag();
        }
        System.out.println(this.endTag);
    }

    @Override
    public void addChildTag(HtmlTag htmlTag) {
        this.childTag.add(htmlTag);
    }

    @Override
    public void removeChildTag(HtmlTag htmlTag) {
        this.childTag.remove(htmlTag);
    }

    @Override
    public List<HtmlTag> getChildTag() {
        return this.childTag;
    }
}

/**
 * <b>Leaf</b> : Extend or implement all method from component
 */

class HtmlElement extends HtmlTag {

    private String tagName;
    private String startTag;
    private String endTag;
    private String tagBody;

    public HtmlElement (String tagName){
        this.tagName = tagName;
    }

    @Override
    public String getTagName() {
        return this.tagName;
    }

    @Override
    public void setStartTag(String tag) {
        this.startTag = tag;
    }

    @Override
    public void setEndTag(String tag) {
        this.endTag = tag;
    }

    @Override
    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    @Override
    public void generateHtmlTag() {
        System.out.println(this.startTag + " " + this.tagBody + " " + this.endTag);
    }
}

public class Composite {

    public static void main(String[] args) {
        // write your code here

        HtmlTag htmlTag = new HtmlParentTag("<html>");
        htmlTag.setStartTag("<html>");
        htmlTag.setEndTag("</html>");

        HtmlTag bodyTag = new HtmlParentTag("<body>");
        bodyTag.setStartTag("<body>");
        bodyTag.setEndTag("</body>");

        HtmlTag pTag = new HtmlElement("<p>");
        pTag.setStartTag("<p>");
        pTag.setEndTag("</p>");
        pTag.setTagBody("Hello every body !!!");

        HtmlTag _pTag = new HtmlElement("<p>");
        _pTag.setStartTag("<p>");
        _pTag.setEndTag("</p>");
        _pTag.setTagBody("Hello every body !!!");

        bodyTag.addChildTag(pTag);
        bodyTag.addChildTag(_pTag);

        htmlTag.addChildTag(bodyTag);

        htmlTag.generateHtmlTag();

    }

}
