package model;

public class TweeterDetailFactory implements TweeterFactory {
    @Override
    public TweeterObject create() {
        return new TweeterDetail();
    }
}
