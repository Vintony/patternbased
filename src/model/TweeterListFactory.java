package model;

public class TweeterListFactory implements TweeterFactory {
    @Override
    public TweeterObject create() {
        return new TweeterList();
    }
}
