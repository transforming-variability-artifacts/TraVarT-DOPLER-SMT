***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar CSV;

csvFile
    : hdr row+ EOF
    ;

hdr
    : row
    ;

row
    : field (',' field)* '\r'? '\n'
    ;

field
    : TEXT
    | STRING
    |
    ;

TEXT
    : ~[,\n\r"]+
    ;

STRING
    : '"' ('""' | ~'"')* '"'
    ; // quote-quote is an escaped quote