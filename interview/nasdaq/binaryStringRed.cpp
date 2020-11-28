#include <bits/stdc++.h> 
#include <ext/pb_ds/assoc_container.hpp> 
using namespace std;
using namespace __gnu_pbds;
// Policy based data structure 
template<class T> using oset=tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>; 
#define ll long long int
#define pii pair<ll,ll>
#define rep(i,st,en) for(ll i=st;i<en;i++)
#define vi vector<ll>
#define vii vector<pii>
#define all(x) x.begin(),x.end()
#define rall(x) x.rbegin(),x.rend()
#define eb emplace_back
#define yes cout<<"YES"<<endl; return;
#define no cout<<"NO"<<endl; return;
#define flus fflush(stdin); fflush(stdout);
#define gin(x) cerr<<#x<<" : "<<x<<" ";
#define fin cerr<<endl;
#define F first
#define S second
#define np next_permutation
#define inf 1e18
#define mod 1000000007
#define N 200009
#define pi (double)2*acos(0.0)
#define minpq priority_queue <ll, vector<ll>, greater<ll>>
#define maxpq priority_queue<ll> 
void sout(){
	cout<<endl;
}
template <typename T,typename... Types>
void sout(T var1,Types... var2){
	cout<<var1<<" ";
	sout(var2...);
}




void solve(){
	ll n;
	cin>>n;
	string s;
	cin>>s;
	stack<int> zero,one;
	ll k=0;
	vi sol(n);
	for(ll i=0;i<n;i++){
		if(s[i]=='0'){
			if(one.empty()){
				k++;
				zero.push(k);
				sol[i]=k;
			} else{
				int ele=one.top();
				one.pop();
				zero.push(ele);
				sol[i]=ele;
			}
		} else{
			if(zero.empty()){
				k++;
				one.push(k);
				sol[i]=k;
			} else{
				int ele=zero.top();
				zero.pop();
				one.push(ele);
				sol[i]=ele;
			}
		}
	}
	cout<<k<<endl;
	for(auto ele:sol) cout<<ele<<" "; cout<<endl;
	
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	clock_t t1=clock();
	int t;
	cin>>t;
	// t=1;
	while(t--){
		solve();
	}
	cerr<<"Time elapsed: "<<(double)(clock()-t1)/1000<<" s"<<endl;
}

 