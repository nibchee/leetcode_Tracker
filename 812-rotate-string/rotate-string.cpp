class Solution {
public:
    bool rotateString(string A, string B) 
    {
        if(A.length()!=B.length())
            return false;
        string c=B+B;
        if(c.find(A)!=string::npos)
            return true;
        else
            return false;
        
    }
};