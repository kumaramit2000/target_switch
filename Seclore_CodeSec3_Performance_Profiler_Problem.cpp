#include <bits/stdc++.h>

using namespace std;

int main() {
	int l;//total number of trace logs in the input
	cin>>l;
	vector<pair<string,pair<string,int>>> logs;
	for(int i=0;i<l;i++){
		// input trace logs
		string f;
		cin>>f;
		string e;
		cin>>e;
		if(e=="exit"){
			int m;
			cin>>m;
			logs.push_back({f,{e,m}});
		} else {
			logs.push_back({f,{e,-1}});
		}
	}
	stack<pair<string,pair<string,int>>> st;
	map<string,set<string>> parent;
	st.push(logs[0]);
	int mu=0;
	unordered_map<string,pair<int,int>> allo;
	unordered_map<string, int> vis;
	unordered_map<string, pair<int,int>> tempval;
	for(int i=1;i<l;i++){
		pair<string,pair<string,int>> temps = st.top();
		string fs = temps.first;
		string es = temps.second.first;
		int ms = temps.second.second;
		pair<string,pair<string,int>> templ = logs[i];
		string fl = templ.first;
		string el = templ.second.first;
		int ml = templ.second.second;
		if(el=="entry"){
			st.push(logs[i]);
		} else {
			if(fs==fl){
				st.pop();
				if(st.size()>0){
					parent[st.top().first].insert(fs);
				}
			}
			int total = allo[fs].first;
			int self = allo[fs].second;
			if(vis[fs]==1){
				allo[fs]={total+tempval[fs].first,self+=tempval[fs].second};
			} else {
				for(auto vis : parent[fs]){
					total+=allo[vis].first;
				}
				tempval[fs]= {total+ml,self+ml};
				allo[fs]={total+ml,self+ml};
			}
			vis[fs]=1;
		}
	}
	vector<pair<string,int>> res;
	res.push_back({logs[0].first,allo[logs[0].first].first});
	for(int i=0;i<l;i++){
		int last = res.size()-1;
		int maxsp=0;
		string cv = "";
		for(auto child : parent[res[last].first]){
			if(allo[child].first>maxsp){
				maxsp = allo[child].first;
				cv = child;
			}
		}
		if(cv!="")
		res.push_back({cv,maxsp});
	}
	for(auto itr : res){
		cout<<itr.first<<" "<<itr.second<<" ";
	}
	cout<<endl;
}

/*
INPUT -
20
open_doc(string) entry
login() entry
send_request() entry
send_request() exit 100
login() exit 100
login() entry
send_request() entry
send_request() exit 100
login() exit 100
read_doc(string) entry
fread() entry
fread() exit 1000
fread() entry
fread() exit 1000
fread() entry
fread() exit 1000
fread() entry
fread() exit 1000
read_doc(string) exit 3000
open_doc(string) exit 1000
*/

/*
OUTPUT -
open_doc(string) 7200 read_doc(string) 6000 fread() 3000
*/