class CelsiusStrategy implements ValueStrategy
{	public CelsiusStrategy(TemperatureModel m) {model = m;}
	public void set(double d){model.setC(d);}
	public double get(){ return model.getC();}
	
	private TemperatureModel model;
}

