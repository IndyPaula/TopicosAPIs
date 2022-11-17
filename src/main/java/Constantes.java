

public class Constantes {

    public static final String URL = "https://countries.trevorblades.com/";
    public static final String QUERYCOUNTRY = "{\"query\":\"query country {\\r\\n\\tcountry(code:\\\"BR\\\"){\\r\\n    name\\r\\n    emoji\\r\\n    continent{\\r\\n      code\\r\\n      name\\r\\n      countries{\\r\\n        name\\r\\n        code\\r\\n        emoji\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}";
    public static final String QUERYCONTINENTS = "{\"query\":\"query{\\r\\n  continents(filter:\\r\\n  {\\r\\n    code:\\r\\n    {\\r\\n      eq: \\\"AF\\\"\\r\\n      \\r\\n    }\\r\\n  })\\r\\n  {\\r\\n    code\\r\\n    name\\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}";
}