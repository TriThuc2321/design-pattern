
public class FactoryMethod {
    public interface IButton {
        void render();
    }

    public class HtmlButton implements IButton {
        @Override
        public void render() {
            System.out.println("html render");
        }
    }

    public class WindowButton implements IButton {
        @Override
        public void render() {
            System.out.println("Window render");
        }
    }

    public class ButtonFactory {
        public enum ButtonType {
            HtmlButton, WindowButton
        }

        public IButton CreateButton(String type) {
            IButton button = null;

            switch (type) {
                case ButtonType.HtmlButton:
                    button = new HtmlButton();
                    break;
                case ButtonType.WindowButton:
                    button = new WindowButton();
                    break;
                default:
                    button = new HtmlButton();
            }
        }
    }

    public static void main(String[] args) {

    }
}
