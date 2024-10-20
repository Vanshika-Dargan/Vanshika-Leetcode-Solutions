class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> exp = new Stack<>();
        Stack<Character> opr = new Stack<>();
        int n = expression.length();
        int i=0;
        while(i<n){
        char ch = expression.charAt(i++);
        if(ch=='&' || ch=='|' || ch=='!'){
            opr.push(ch);
        }
        else if(ch=='(' || ch=='f' || ch=='t'){
            exp.push(ch);
        }
        else if(ch==')'){
            char operation = opr.pop();
            char eval = exp.pop();
            if(operation == '!'){
                exp.pop();
                boolean res=!(eval=='t'?true:false);
                exp.push(res==true?'t':'f');
            }
            else{
            boolean res = operation == '&' ? true: false;
            while(eval != '('){           
                if(operation == '&'){
                res = res && (eval=='t'?true:false);
                }
                else{
                    res = res || (eval=='t'?true:false);
                }
                eval = exp.pop();
            }
            exp.push(res==true?'t':'f');
            }
        }
        }
        return exp.pop() == 't'?true: false;
    }

    
}