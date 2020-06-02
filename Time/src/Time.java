class Time
{
	public static void main(String[] args) throws Exception
	{	
		long milli, s, s1, m, m1, h, d, h1;

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		milli = System.currentTimeMillis();

		s = milli/1000;

		while(true)
		{
			m = s/60;
			s1 = s%60;
			h = m/60;
			h1 = h%24;
			m1 = m%60;
			System.out.println(h1+":"+m1+":"+s1);

			Thread.currentThread().sleep(1000);

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			s++;
		}	
	}
}