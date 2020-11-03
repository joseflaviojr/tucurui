#!/usr/bin/env groovy

@Grab("com.joseflavio:urucum:1.0-A15")
import com.joseflavio.urucum.tucurui.*

assert args.length == 1

print TucuruiUtil.abrir(args[0]).gerarXML()
