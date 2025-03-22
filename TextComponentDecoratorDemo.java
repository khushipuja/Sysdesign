package Cases;

//Interface for text component
interface TextComponent{
    public String getText();
}

//Concrete Component representing plain text
class PlainTextComponent implements TextComponent{
    private String text;

    public PlainTextComponent(String text){
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }
}

//Decorator abstract class
abstract class TextComponentDecorator implements TextComponent{
    private TextComponent textComponent;

    public TextComponentDecorator(TextComponent textComponent){
        this.textComponent = textComponent;
    }

    @Override
    public String getText() {
        return textComponent.getText();
    }
}

//Concrete Decorator for applying font style
class FontDecorator extends TextComponentDecorator{
    String fontStyle;
    private TextComponent textComponent;

    public FontDecorator(TextComponent textComponent,String fontStyle) {
        super(textComponent);
        this.fontStyle = fontStyle;
        this.textComponent = textComponent;
    }

    @Override
    public String getText() {
        return "<font style=\"" + fontStyle + "\">" + textComponent.getText() + "</font>";
    }
}

//Concrete Decorator for applying font size
class FontSizeDecorator extends TextComponentDecorator{
    String fontSize;
    private TextComponent textComponent;

    public FontSizeDecorator(TextComponent textComponent,String fontStyle) {
        super(textComponent);
        this.fontSize = fontStyle;
        this.textComponent = textComponent;
    }

    @Override
    public String getText() {
        return "<font size=\"" + fontSize + "\">" + textComponent.getText() + "</font>";
    }
}

public class TextComponentDecoratorDemo {

    public static void main(String[] args) {
        PlainTextComponent plainTextComponent = new PlainTextComponent("Hello World");
        FontDecorator fontDecorator = new FontDecorator(plainTextComponent,"Arial");
        FontSizeDecorator fontSizeDecorator = new FontSizeDecorator(fontDecorator,"small");
        System.out.println(fontSizeDecorator.getText());

    }
}
