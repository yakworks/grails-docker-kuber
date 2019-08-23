package grello

class HomeController {

    def index() {
    	log.debug("**** HomeController index debug test ***")
    	log.info("HomeController index test info logging")
    	log.warn("HomeController index test warning logging")
    	log.error("HomeController index test error logging")
    	render(view:'/index', model: [userList: User.list()])
    	//respond view:'/foo.gsp'
    }
}