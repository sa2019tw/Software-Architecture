#include "db.h"

sqlite3 * pDB = NULL;
int nRes = sqlite3_open("./db/test.db", &pDB);
//int check_class_exist = 0;
