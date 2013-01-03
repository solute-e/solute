namespace java com.solute.thrift.gen

service EchoService {
	void put(1: string id, 2: string echoStr),
	string get(1: string id)
}