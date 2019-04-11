using Software_Architecture.adapter.presenter;
using Software_Architecture.usecase.getAllCourses;
using Software_Architecture.usecase.getCourseByTitle;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Software_Architecture.adapter
{
    public class PresenterToViewModel
    {
        public PresenterToViewModel() {}

        public ViewModel getCourseByTitlePresenterToViewModel(GetCourseByTitleOutput getCourseByTitlePresenter) {
            ViewModel viewModel = new ViewModel();
            viewModel.setDescription(getCourseByTitlePresenter.getDescription());
            viewModel.setSuitable(getCourseByTitlePresenter.getSuitable());
            viewModel.setPrice(getCourseByTitlePresenter.getPrice());
            viewModel.setNotice(getCourseByTitlePresenter.getNotice());
            viewModel.setOther(getCourseByTitlePresenter.getOther());
            return viewModel;
        }

        public ViewModel getAllCoursesPresenterToViewModel(GetAllCoursesOutput getAllCoursesPresenter) {
            ViewModel viewModel = new ViewModel();
            viewModel.setDataTable(getAllCoursesPresenter.getCourseDataTable());
            return viewModel;
        }
    }
}
