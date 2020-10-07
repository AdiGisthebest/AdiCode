class HelloWorld {
    /* You have to include the type of the variable the function takes in. */
    /* You have to specify the return type, if none, say void. */
    /*You have to return the type specified if your return type is not void.*/
    public int myFunction2(int num, int num2) {
        return ;
    }
    public static void main(String[] args) {
        /*Here we are getting a copy of our HelloWorld Object by saying new HelloWorld(). Then we are calling the function we defined by doing the variable name dot function name followed by two braces, with the input data inside in the right order*/
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.myFunction2(1,2);
    }
}


