//#include "tst_test01.h"

#include "./test_entities/test_course.h"
#include "./test_data_access/test_inmemory.h"
#include "./test_usecases/test_manage_course.h"
#include "./test_data_access/test_txt.h"

#include <gtest/gtest.h>

int main(int argc, char *argv[])
{
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
