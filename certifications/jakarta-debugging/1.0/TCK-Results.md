TCK Results
===========

As required by the
[Eclipse Foundation Technology Compatibility Kit License](https://www.eclipse.org/legal/tck.php),
following is a summary of the TCK results for releases of Jakarta Jakarta Debugging Support for Other Languages.

# Eclipse GlassFish 5.1 Certification Request

- Product Name, Version and download URL (if applicable) \
  [Eclipse GlassFish 5.1](https://www.eclipse.org/downloads/download.php?file=/glassfish/glassfish-5.1.0.zip)
  This specification does not define an API. The TCK verifies required behavior.
- Specification Name, Version and download URL \
  [Jakarta Jakarta Debugging Support for Other Languages 1.0](https://jakarta.ee/specifications/debugging/1.0/)
- TCK Version, digital SHA-256 fingerprint and download URL \
  [Jakarta Jakarta Debugging Support for Other Languages TCK 1.0.0](http://download.eclipse.org/ee4j/jakartaee-tck/jakartaee8-eftl/promoted/eclipse-debugging-tck-1.0.0.zip), SHA-256: `5c7d27ea18236bc810da236a939ff3cc5006feb672141619692eda87ebd0ef96`
- Public URL of TCK Results Summary \
  [TCK results summary](TCK-Results.html)
- Any Additional Specification Certification Requirements \
  None
- Java runtime used to run the implementation \
  Oracle JDK 1.8.0_191
- Summary of the information for the certification environment, operating system, cloud, ... \
  Linux Centos 7

Test results:

```
++ grep 'is a correctly formatted SMAP' smap.log
++ wc -l
+ output=1
+ echo 1
1
+ [[ 1 < 1 ]]
+ failures=0
+ status=Passed
+ echo '<testsuite id="1" name="debugging-tck" tests="1" failures="0" errors="0" disabled="0" skipped="0">'
+ echo '<testcase name="VerifySMAP" classname="VerifySMAP" time="0" status="Passed"><system-out></system-out></testcase>'
+ echo '</testsuite>'

```