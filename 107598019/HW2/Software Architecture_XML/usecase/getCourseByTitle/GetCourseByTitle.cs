﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.usecase.getCourseByTitle
{
    public interface GetCourseByTitle
    {
        void execute(GetCourseByTitleInput input, GetCourseByTitleOutput output);
    }
}
