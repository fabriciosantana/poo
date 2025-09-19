class SafeStack extends Stack implements ISafeStack {

    public SafeStack(int capacity) { super(capacity); }

    @Override
    public boolean isEmpty() { return tos < 0; }

    @Override
    public boolean isFull()  { return tos >= elements.length-1; }
} 