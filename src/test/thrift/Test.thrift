namespace java com.solute.test.thrift.gen

service TestService {
	void put(1: string id),
	string get(1: string id)
}