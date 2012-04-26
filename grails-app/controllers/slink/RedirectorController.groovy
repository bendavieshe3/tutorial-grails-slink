package slink

class RedirectorController {

    def index(String shortLinkName) {
		redirect url:Shortlink.findByShortLink(shortLinkName).targetUrl	
	}
}
