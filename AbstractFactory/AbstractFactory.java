
public class AbstractFactory {
    public interface Button {
        void paint();
    }

    public static class MacOSButton implements Button {
        @Override
        public void paint() {
            System.out.println("MacOS button");
        }
    }

    public static class WindowButton implements Button {
        @Override
        public void paint() {
            System.out.println("Window button");
        }
    }

    public static interface Checkbox {
        void paint();
    }

    public static class MacOSCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("MacOS check box");
        }
    }

    public static class WindowCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Window check box");
        }
    }

    public static interface GUIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    public static class MacOSFactory implements GUIFactory {
        public MacOSFactory() {
        }

        @Override
        public Button createButton() {
            return new MacOSButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    public static class WindowFactory implements GUIFactory {
        public WindowFactory() {
        }

        @Override
        public Button createButton() {
            return new MacOSButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    public static class Application {
        private Button button;
        private Checkbox checkbox;

        public Application(GUIFactory guiFactory) {
            button = guiFactory.createButton();
            checkbox = guiFactory.createCheckbox();
        }

        public void paint() {
            button.paint();
            checkbox.paint();
        }
    }

    private static Application config() {
        Application app;
        GUIFactory factory;
        Boolean createMac = true;

        if (createMac) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowFactory();
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = config();
        app.paint();
    }
}
