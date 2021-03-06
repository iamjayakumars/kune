#!/usr/bin/gawk
# This receibe something like
# lang|file-used-in-gtype|trkey|text
BEGIN {
}
{
    gtype = $2"ł"$3
    if (gtypeprefix)
	gtype = gtypeprefix"ł"gtype
    langCode =$1
    propKey = $3
    text = $4
    if (langCode == "en") {
	currentLang = english
    } else {
	currentLang = getLangId(langCode)
    }
    if (verbose > 0)
	print "Current lang id: " currentLang " code: " langCode
    if (currentLang <= 0) {
	print "Error getting the lang code, so stopping"
	exit
    }
    result = getKeyInLang(gtype, currentLang)
    if (result > 0) {
	if (verbose > 0)
	    print "'"propKey "' already in db for lang '" langCode "'"
    } else {
	if (verbose > 0)
	    print "'"propKey "' don't exists, so let's try to insert"
	if (currentLang == english) {
	    insertNewItem(text, "NULL", gtype, currentLang, "NULL", propKey, langCode)
	    # FIXME, parent id = self
	    id = getKeyInLang(gtype, currentLang)
	    updateParentId(id);
	} else {
	    # Other langs different than English
	    parent = getKeyInLang(gtype, english)
	    # find English parent
	    if (parent > 0) {
		# parent found, insert with reference
		insertNewItem("NULL", text, gtype, currentLang, parent, propKey, langCode)
	    } else {
		print "'"propKey "' is not added for language English so no processing it for lang '" langCode "'"
	    }
	}
    }
}
END {
}

