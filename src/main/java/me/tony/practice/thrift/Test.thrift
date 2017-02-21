namespace java me.tony.practice.thrift

enum Gender {
MALE,FEMALE
}

struct User {
1: required string name
2: required Gender gender
3: required string usercode
4: required i32 age
}

service UserService {
User findByUsercode(3: string usercode)
bool exist(3: string usercode)
list<User> findByName(1: string name)
}