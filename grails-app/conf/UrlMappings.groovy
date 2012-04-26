class UrlMappings {

	static mappings = {
        "/admin/$action?/$id?" (controller:"admin")
        "/$shortLinkName" (controller:"redirector")

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
