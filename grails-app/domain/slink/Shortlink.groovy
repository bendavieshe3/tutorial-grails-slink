package slink

class Shortlink {

	String shortLink
	String targetUrl
	
    static constraints = {
		shortLink size:1..25
		targetUrl size:1..255
    }
}
