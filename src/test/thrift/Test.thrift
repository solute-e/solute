namespace java com.solute.test.thrift.gen

service TestService {
	void put(1: string id, 2: string str),
	string get(1: string id)
}