package slink
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Shortlink)
class ShortlinkTests {

    void testExpectedInputOK() {
		def s = new Shortlink(shortLink:'grails', targetUrl:'http://grails.org')
		mockForConstraintsTests(Shortlink, [s])
		
		assert s.validate()
    }
	
	void testNullValuesFailValidation() {
		def s = new Shortlink()

		mockForConstraintsTests(Shortlink, [s])
		
		assert !s.validate()
		assert 'nullable' == s.errors['shortLink']
		assert 'nullable' == s.errors['targetUrl']
		
	}
	
	void testLongShortLinkFailsValidation() {
		def s = new Shortlink (shortLink:'Iamareallylongshortlinkwhichshouldnotbeallowed',
			targetUrl:'http://grails.org')
		
		mockForConstraintsTests(Shortlink, [s])
		
		assert !s.validate()
		assert s.hasErrors()
		assert s.errors['shortLink'] == 'size'
	}
	
	void testInvalidCharactersInShortLinkFailsValidation()
	{
		def s = new Shortlink (shortLink:'a short link',
			targetUrl:'http://grails.org')
		mockForConstraintsTests(Shortlink, [s])
		assert !s.validate()
		
	}
	
	void testInvalidUrlInTargetUrlFailsValidation()
	{
		def s = new Shortlink (shortLink:'grails',
			targetUrl:'not a URL')
		mockForConstraintsTests(Shortlink, [s])
		assert !s.validate()
		
	}
}
