class Stack implements IStack {
    protected Object[] elements;
    protected int tos;
    
    public Stack(int capacity) {
        elements = new Object[capacity];
        tos = -1;
    }

    @Override
    public void push(Object item) { elements[++tos] = item; }

    @Override
    public Object pop() {
        Object objRef = elements[tos];
        elements[tos] = null;
        tos--;
        return objRef;
    }

    public Object peek() { return elements[tos]; } 
}