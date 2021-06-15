package org.example.designpattern.decorator;

public class ConcreteComponent extends Component{
    @Override
    public void operation() {
        System.out.println("原始Component的操作");
    }
}
