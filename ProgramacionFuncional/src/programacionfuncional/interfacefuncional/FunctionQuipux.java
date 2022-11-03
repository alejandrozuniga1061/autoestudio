package programacionfuncional.interfacefuncional;

@FunctionalInterface
public interface FunctionQuipux {
	
    String sayHelloTo(String name);
    
    public default String sayHelloWord(){
        return "Hello word";
    } 
	
}
