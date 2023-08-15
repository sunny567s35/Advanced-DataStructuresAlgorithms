class RomantoInteger {
    public int romanToInt(String s) {
        HashMap<Character , Integer > map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum =0;
        for(int i = 0 ; i <= s.length()-1; i++){
           int j = i+1;
                int n1 = map.get(s.charAt(i));

                if(j<s.length()){
                    int n2 = map.get(s.charAt(j));
                        if(n1 < n2){
                            sum -=n1;
                            System.out.println(sum);
                        }
                        else{
                            sum+=n1;
                            System.out.println(sum);
                        }
                    }
                    else{
                        sum+=n1;
                    }
                
            
        }
        return sum;
    }
}