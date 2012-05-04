package slink

class Shortlink {

	String shortLink
	String targetUrl
	
    static constraints = {
		shortLink size:1..25, matches:"[a-zA-Z0-9]+"
		targetUrl size:1..255, url:true
    }
}
