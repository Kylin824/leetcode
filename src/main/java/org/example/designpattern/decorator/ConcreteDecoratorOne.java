package org.example.designpattern.decorator;

public class ConcreteDecoratorOne extends Decorator{

    private Component component;

    public ConcreteDecoratorOne(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.println("装饰器1添加功能");
        component.operation();
    }

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decoratorOne = new ConcreteDecoratorOne(component);
        // 使用装饰类的方法来加强component的功能
        decoratorOne.operation();
    }
}
