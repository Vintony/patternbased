package model;

public class TweeterAbstractFactory implements TweeterFactory {
    @Override
    public TweeterObject create() {
        return new TweeterAbstract();
    }
}
