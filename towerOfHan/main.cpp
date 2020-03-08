#include <bits/stdc++.h>
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
#include <ext/pb_ds/assoc_container.hpp> // Common file

using namespace __gnu_pbds;
using namespace std;

typedef long long  ll;
typedef long double  dbl;

template <class T>
using OSet= tree<T,null_type,greater<T>,rb_tree_tag,tree_order_statistics_node_update>;

#define endl "\n"
#define ee cout<<endl;
#define X first
#define Y second
#define maxx(a,b) a=max(a,b)
#define minn(a,b) a=min(a,b)
#define all(v) (v.begin(),v.end())

const int N=2e5+10,C=200,O=127,OO=0x7F7F7F7F;
const dbl EPS=-1e7;



bool fil(int n,int src,int tmp ,int dest){

    if(n>0){
        fil(n-1,src,dest,tmp);
        cout<<"Disk "<<n<<" moved from "<<(char)('A'+src)<<" to "<<(char)('A'+dest)<<endl;
        fil(n-1,tmp,src,dest);

    }


    return 0;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL),cout.tie(NULL);

    int n;
    cin>>n;

    fil(n,0,1,2);

}
