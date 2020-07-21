BUI.use('common/main', function () {

    var config = [{
        homePage: '12',
        id: 'menu',
        menu: [{
            text: '预警列表维护',
            items: [{id: '11', text: '列表新建', href: "/forward/addch"},
                {id: '12', text: '列表管理', href: '/forward/querylist'}
            ]
        }, {
            text: '预警消息管理',
            items: [{id: '21', text: '订座预警查询', href: '/icswarning'},
                {id: '22', text: '离港预警查询', href: '/dcswarning'},
            ]
        }, {
            text: '单人细查',
            items: [{id: '31', text: '订座实时查询', href: '/forward/icstime'},
                {id: '32', text: '离港实时查询', href: '/forward/dcstime'},
                {id: '33', text: '订座历史查询', href: '/forward/icshistory'},
                {id: '34', text: '离港历史查询', href: '/forward/dcshistory'},
            ]
        }, {
            text: '用户操作日志',
            items: [{id: '41', text: '操作日志查询', href: '/forward/searchlog'},

            ]
        }
        ]
    },];
    new PageUtil.MainPage(
        {
            modulesConfig: config
        });
});